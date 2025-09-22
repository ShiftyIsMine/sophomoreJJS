package kr.ac.kopo.konumon.springboot_jdbctest.controller;

import kr.ac.kopo.konumon.springboot_jdbctest.domain.Detail;
import kr.ac.kopo.konumon.springboot_jdbctest.domain.Product;
import kr.ac.kopo.konumon.springboot_jdbctest.repository.DetailRepository;
import kr.ac.kopo.konumon.springboot_jdbctest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam05")
public class Example05Controller {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DetailRepository detailRepository;

    @GetMapping
    public String requestInsert(Model model){
        Product product = new Product();
        product.setName("Iphone 17");
        product.setPrice(1200000);


        Detail detail = new Detail();
        detail.setDescription("new 17");
        detail.setWidth(3000f);
        detail.setHeight(3000f);
        detail.setWeight(3000f);

        product.setDetail(detail);
        productRepository.save(product);

        Iterable<Product> products = productRepository.findAll();
        Iterable<Detail> detailList = detailRepository.findAll();

        model.addAttribute("productList", products);
        model.addAttribute("detailList", detailList);

        return "viewPage05";

    }
}
