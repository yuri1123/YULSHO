package com.yuri.shoppingsite;

import com.yuri.shoppingsite.Repository.AnswerRepository;
import com.yuri.shoppingsite.Repository.ProductsRepository;
import com.yuri.shoppingsite.Repository.QuestionRepository;
import com.yuri.shoppingsite.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ShoppingsiteTest {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ProductsRepository productsRepository;

//    @Test
//    void testJpa() {
//
//        Products products = Products.builder().
//                category("DIARY")
//                .productname("2023년 파랑 다이어리")
//                .productcontent("산뜻하고 예쁜 청량감있는 다이어리입니다.")
//                .price("15000원")
//                .build();
//
//        for (int i = 0; i < 3; i++) {
//            products.addImage(UUID.randomUUID().toString(), "file" + i + ".jpg");
//        }
//
//        productsRepository.save(products);
//
//
//    }
//
//    @Test
//    void testReadWithImages() {
//
//        Optional<Products> result = productsRepository.findByIdWithImages(1L);
//        Products products = result.orElseThrow();
//
//        System.out.println(products);
//        System.out.println("------------------");
//        for(BoardImage boardImage : products.getImageSet()){
//        System.out.println(boardImage);
//        }
//
//    }
//
//    @Transactional
//    @Commit
//    @Test
//    public void testModifyImages(){
//        Optional<Products> result = productsRepository.findByIdWithImages(1L);
//        Products products = result.orElseThrow();
//
//        //기존것은 삭제
//        products.clearImage();
//
//        //새로운 첨부파일
//        for(int i =0; i <2; i++){
//            products.addImage(UUID.randomUUID().toString(), "updatefile"+i+".jpg");
//        }
//        productsRepository.save(products);
//    }
//
//    @Test
//    public void testInsertAll(){
//        for(int i = 1; i<=100; i++){
//            Products products = Products.builder()
//                    .category("Category"+i)
//                    .productname("ProductName"+i)
//                    .productcontent("ProductContent"+i)
//                    .etc("Etc"+i)
//                    .regDate(LocalDateTime.now()).build();
//
//            for(int j=0; j<3; j++){
//                if(i%5 ==0){
//                    continue;
//                }
//            products.addImage(UUID.randomUUID().toString(),i+"file"+j+".jpg");
//            }
//        productsRepository.save(products);
//        }
//    }


//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);

//        for(int i=1; i<=300; i++){
//            String subject = String.format("테스트 데이터입니다:[%03d]",i);
//            String content = "내용없움";
//            this.questionService.create(subject,content);
//        }
    }