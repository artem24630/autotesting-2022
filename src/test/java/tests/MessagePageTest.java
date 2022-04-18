package tests;

import static com.google.common.truth.Truth.assertThat;
import pages.MessagesPage;
import pages.elements.ChatPageElement;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.Duration;
import java.util.List;

class MessagePageTest extends AbstractTest {

    private static final Duration TIMEOUT = Duration.ofSeconds(2);

    @Test
    void correctMessagePage() {
        MessagesPage.getInstanse().get();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Мобильная разработка s22",
            "Технополис. Java – 20 (набор 2021)",
            "NoSQL s22",
            "Углубленное программирование на Java  2021"
    })
    void testContainsChats(String title) {
        MessagesPage messagePage = MessagesPage.getInstanse().get();
        assertThat(messagePage.getChatsTitle()).contains(title);
    }

    @Nested
    @DisplayName("Tests for chats")
    class ChatTests {

        private static MessagesPage messagePage;
        private final String title = "Test";

        @BeforeAll
        static void setUp() {
            messagePage = MessagesPage.getInstanse().get();
        }

        @BeforeEach
        void createChat() {
            int countBefore = messagePage.getChatsTitle().size();
            messagePage.createChatWithTitle(title);
            Selenide.Wait().withTimeout(TIMEOUT).until((o) ->
                    messagePage.getChatsTitle().contains(title)
            );
            List<String> chatsTitle = messagePage.getChatsTitle();
            assertThat(chatsTitle).contains(title);
        }

        @Test
        void sendMessageTest() {
            ChatPageElement chat = messagePage.getChatWithTitle(title);
            //TODO тест на отправку сообщения
        }

        @AfterEach
        void deleteChat() {
            messagePage.deleteChatWithTitle(title);
            Selenide.Wait().withTimeout(TIMEOUT).until((o) ->
                    !messagePage.getChatsTitle().contains(title)
            );
            assertThat(messagePage.getChatsTitle()).doesNotContain(title);
        }

    }

}
