package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {

    private static final String PARAM = "1";

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser
    void toSave() throws Exception {
        this.mockMvc.perform(get("/toSave"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("save"));
    }

    @Test
    @WithMockUser
    void toUpdate() throws Exception {
        this.mockMvc.perform(get("/toUpdate").param("idPost", PARAM))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("update"));
    }

    @Test
    @WithMockUser
    void toPost() throws Exception {
        this.mockMvc.perform(get("/toPost").param("idPost", PARAM))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }
}
