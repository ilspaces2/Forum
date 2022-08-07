package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostRepositoryService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {

    private static final String PARAM = "1";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostRepositoryService postService;

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

    @Test
    @WithMockUser
    public void whenSavePost() throws Exception {
        this.mockMvc.perform(post("/save")
                        .param("name", "Куплю ладу-грант")
                        .param("description", "Дорого.")
                        .param("username", "ladaUser"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).save(argument.capture());
        assertThat(argument.getValue().getName(), is("Куплю ладу-грант"));
        assertThat(argument.getValue().getDescription(), is("Дорого."));
        assertThat(argument.getValue().getUsername(), is("ladaUser"));
    }

    @Test
    @WithMockUser
    public void whenUpdatePost() throws Exception {
        this.mockMvc.perform(post("/update")
                        .param("name", "Куплю ладу-грант")
                        .param("description", "Продано"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).update(argument.capture());
        assertThat(argument.getValue().getName(), is("Куплю ладу-грант"));
        assertThat(argument.getValue().getDescription(), is("Продано"));
    }
}
