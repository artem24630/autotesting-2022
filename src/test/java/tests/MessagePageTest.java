package tests;

import static com.google.common.truth.Truth.assertThat;
import pages.MessagePage;
import pages.elements.ChatPageElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MessagePageTest extends AbstractTest {

    @Test
    void correctMessagePage() {
        MessagePage messagePage = new MessagePage();
        messagePage.get();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Мобильная разработка s22", "Технополис. Java – 20 (набор 2021)", "NoSQL s22", "Углубленное программирование на Java  2021"})
    void testContainsChats(String title) {
        MessagePage messagePage = new MessagePage().get();
        assertThat(messagePage.getChatsTitle()).contains(title);
    }

    @Nested
    @DisplayName("Tests for chats")
    class ChatTests {
        private static MessagePage messagePage;
        private final String title = "Test";

        @BeforeAll
        static void setUp() {
            messagePage = new MessagePage().get();
        }

        @BeforeEach
        void createChat() {
            messagePage.createChatWithTitle(title);
            assertThat(messagePage.getChatsTitle()).contains(title);
        }


        @Test
        void sendMessageTest() {
            ChatPageElement chat = messagePage.getChatWithTitle(title);
        }

        @AfterEach
        void deleteChat() throws InterruptedException {
            messagePage.deleteChatWithTitle(title);
//            Thread.sleep(2000);
            assertThat(messagePage.getChatsTitle()).doesNotContain(title);
        }

    }
}
