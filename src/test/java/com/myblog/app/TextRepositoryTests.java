//package com.myblog.app;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//import com.myblog.app.model.Text;
//import com.myblog.app.model.User;
//import com.myblog.app.repository.TextRepository;
//import com.myblog.app.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class TextRepositoryTests {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private TextRepository repo;
//
//    @Autowired
//    private UserRepository repo0;
//
//    @Test
//    public void testCreateText() {
//        Text text = new Text();
//
////        User user = new User();
////        user.setEmail("hhhhdfh@gmail.com");
////        user.setPassword("rfdsqfavi2020");
////        user.setName("Raqsdffdvi");
////
////        User savedUser = repo0.save(user);
////
////        User existUser = entityManager.find(User.class, savedUser.getId());
//        User user = new User();
//        user.setEmail("erge@gmail.com");
//        user.setPassword("aegfaezf");
//        user.setName("dsvdsfs");
//
//        User savedUser = repo0.save(user);
//
//
//
//
//
////        text.setUser(user);
//        text.setText("oooooooooooooo ");
//
//        Text savedText = repo.save(text);
//
//        Text existText = entityManager.find(Text.class, savedText.getIdText());
//
//        assertThat(text.getIdText()).isEqualTo(existText.getIdText());
//
//    }}