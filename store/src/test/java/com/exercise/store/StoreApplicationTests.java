//package com.exercise.store;
//
//import com.util.repo.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class StoreApplicationTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ProductRepository repository;
//
//   @Test
//    public void getAllTest() throws Exception {
//        mockMvc.perform(get("/allProducts"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isArray());
//    }
//
//    @Test
//    public void addProductTest() throws Exception {
//        String newProductJson = """
//                {
//                    "code": "123",
//                    "description": "Test Product",
//                    "price": 19.99
//                }
//                """;
//        mockMvc.perform(post("/addProduct")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(newProductJson))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string("Product added successfully."));
//    }
//
//    @Test
//    public void deleteProductFoundTest() throws Exception {
//        mockMvc.perform(delete("/deleteProduct")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("0000000123"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string("Product with code 0000000123 deleted successfully."));
//    }
//
//    @Test
//    public void addProductValidationError() throws Exception{
//       String newNotValidProduct = """
//                               {
//                                   "code": "",
//                                   "description": "",
//                                   "price": 10
//                               }
//                               """;
//       mockMvc.perform(post("/addProduct").contentType(MediaType.APPLICATION_JSON).content(newNotValidProduct))
//               .andDo(print())
//               .andExpect(status().isBadRequest())
//               .andExpect(jsonPath("$.code").value("Code cannot be blank"));
//
//    }
//}
