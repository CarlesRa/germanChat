package com.carlesramos.firebasechat;

import java.util.Date;

public class ChatMessage {
   private String username;
   private long time;
   private String message;

   public ChatMessage() {
      // Firebase requiere que exista un constructor sin parámetros
   }

   public ChatMessage(String username, String message) {
      this.username = username;
      this.message = message;
      time = new Date().getTime();
   }

   public String getUsername() {
      return username;
   }

   public long getTime() {
      return time;
   }

   public String getMessage() {
      return message;
   }

}
