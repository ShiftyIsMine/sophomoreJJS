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

@Controller
@RequestMapping("/exam06")
public class Example06Controller {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DetailRepository detailRepository;

    @GetMapping
    public String requestInsert(Model model){
        Product product = new Product();
        product.setName("GalaxyTab S11");
        product.setPrice(1200000);


        Detail detail = new Detail();
        detail.setDescription("펜이 너무 안 조아요");
        detail.setWidth(3000f);
        detail.setHeight(3000f);
        detail.setWeight(3000f);
        detail.setProduct(product);
        detailRepository.save(detail);

        product.setDetail(detail);
        productRepository.save(product);

        Iterable<Product> products = productRepository.findAll();
        Iterable<Detail> detailList = detailRepository.findAll();

        model.addAttribute("productList", products);
        model.addAttribute("detailList", detailList);

        return "viewPage06";

    }
}
