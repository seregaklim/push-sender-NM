package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)


    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "vasya",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken("dpeQvWZjRrC2Qni3-TTMJj:APA91bEjaWW1BIFtgNLkGHjhzcyW-olcHk7GH-iVneFcqArPIk6gy_Nqq4oDJLO365jmHJ7w-IEW07E0R5BfS1EsUP5fiM99tPAjh6M0aazrX73L-25h153XTMGuo6oGfrYfNkQhEsuT")
        .build()

    val message1 = Message.builder()
        .putData("action", "POST")
        .putData("content", """{
          "userId": 1,
          "userName": "vasya",
          "postId": 2,
          "content": "Как сидеть на карантине с пользой? Сделать все домашние дела и кодить, кодить,кодить.......!"
        }""".trimIndent())
        .setToken("dpeQvWZjRrC2Qni3-TTMJj:APA91bEjaWW1BIFtgNLkGHjhzcyW-olcHk7GH-iVneFcqArPIk6gy_Nqq4oDJLO365jmHJ7w-IEW07E0R5BfS1EsUP5fiM99tPAjh6M0aazrX73L-25h153XTMGuo6oGfrYfNkQhEsuT")
        .build()


    FirebaseMessaging.getInstance().send(message)
    FirebaseMessaging.getInstance().send(message1)

}
