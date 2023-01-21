package se.JensenYH.Java.SaltMerch.backendProject;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import se.JensenYH.Java.SaltMerch.backendProject.Model.CartItem;
import se.JensenYH.Java.SaltMerch.backendProject.Model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.controller.ProductController;
import se.JensenYH.Java.SaltMerch.backendProject.repository.CartRepository;
import se.JensenYH.Java.SaltMerch.backendProject.repository.ProductRepository;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static jdk.internal.jimage.ImageReaderFactory.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MainRepositoryTest {
/*
	@Autowired
	CartService cartService;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	@MockBean
	private CartRepository cartRepository;

	@Test
	void contextLoads() {
		CartItem cart = new  CartItem();
		cart.setColor("1");
		cart.setSize("11");
		cart.setColor("5");

		CartItem cart2 = new  CartItem();
		cart.setTitle("title");
		cart.setSize("size 12");
		cart.setColor("5");

		List<CartItem> cartItem = new ArrayList<>();

		cartItem.add(cart);
		cartItem.add(cart2);

		when(cartRepository.selectAllItems()).thenReturn(cartItem);
		assertEquals(cartService.selectAllItems(), cartItem);
	}

	private <SELF extends AbstractBigDecimalAssert<SELF>> AbstractBigDecimalAssert assertThat(List<CartItem> selectAllItems) {
		return null;
	}


	@Test
	public void getAllProductsTest() {
		when(productRepository.selectAll()).thenReturn(Stream.of
				(new Product(),
						new Product()).collect(Collectors.toList()));
		assertEquals(2,productService.selectAll().size());
	}

	@Test
	public void getproductById(String catagory) {

	}

*/

}


