package com.acn.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.acn.model.LastTrade;
import com.acn.model.Product;
import com.acn.repository.ProductRepository;


@RestController //with rest controller you get only jsons
// by normal controller you get normal data 
public class PriceController {
	private final static String DOMAIN = "https://api.pro.coinbase.com";
	
	@Autowired
	public RestTemplate restTemplate;
	
	private ProductRepository productRepository;
	
	@GetMapping("/prices/{product_id}")
	public LastTrade readLastTrade(@PathVariable("product_id") String productid) {
		 RestTemplate rt = new RestTemplate();
         HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
         HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
         String url
           = "{{domain}}/products/{{product_id}}/ticker";
         url = url.replace("{{product_id}}", productid);
         url = url.replace("{{domain}}", DOMAIN);
         ResponseEntity<LastTrade> res = rt.exchange(url, HttpMethod.GET, entity, LastTrade.class);
         return res.getBody();
	}
	
	@GetMapping ("/prices")
	public List<LastTrade> readAllLastTrade(){
		Iterable<Product> products = productRepository.findAll();
		List<LastTrade> lastTradeList = new ArrayList<LastTrade>();
		for (Product p : products) {
			if (!(p.getProduct_id().equals(null))) {
				lastTradeList.add(readLastTrade(p.getProduct_id()));
		}}
		return lastTradeList;
	}
	

}
