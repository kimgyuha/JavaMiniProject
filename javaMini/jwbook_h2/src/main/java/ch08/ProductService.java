package ch08;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class ProductService {
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		Product p = new Product("101", "애플사과폰 12", "애플전자", 1200000,"2020.12.12");
		products.put("101", p); // 101을 키로, p(5가지 상품정보)를 values로 맵에 넣음
		p = new Product("102","삼전우주폰 21","삼전전자",1300000,"2021.2.2");
		products.put("102", p);
		p = new Product("103","엘스듀얼폰","엘스전자",1500000,"2021.3.2");
		products.put("103", p);
	}
	public List<Product> findAll(){
		return new ArrayList<>(products.values());
		// 모든 상품 정보를 리스트 형태로 반환하는 메서드, products 맵의 값들을 리스트로 변환하여 반환함
	}
	public Product find(String id) {
		return products.get(id);
	}
}
