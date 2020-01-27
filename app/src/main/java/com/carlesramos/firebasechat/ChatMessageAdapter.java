package com.carlesramos.firebasechat;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.Date;

public class ChatMessageAdapter extends FirestoreRecyclerAdapter<ChatMessage,ChatMessageAdapter.ChatMessageHolder> {

   public ChatMessageAdapter(@NonNull FirestoreRecyclerOptions<ChatMessage> options) {
      super(options);
   }

   @Override
   protected void onBindViewHolder(@NonNull ChatMessageHolder chatMessageHolder, int i, @NonNull ChatMessage chatMessage) {
      chatMessageHolder.tvUsername.setText(chatMessage.getUsername());
      Date date = new Date(chatMessage.getTime());
      //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
      chatMessageHolder.tvTime.setText(DateFormat.format("dd/MM/yyyy HH:mm", date));
      chatMessageHolder.tvMessage.setText(chatMessage.getMessage());
   }

   @NonNull
   @Override
   public ChatMessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message, parent, false);
      return new ChatMessageHolder(v);
   }

   @Override
   public void onDataChanged() {
      super.onDataChanged();

      // Es invocado cada vez que la consulta devuelve un conjunto de datos distinto
   }

   @Override
   public void onError(@NonNull FirebaseFirestoreException e) {
      super.onError(e);
      // Es invocado cuando la consulta devuelve un error.
      // Útil para mostrarle al usuario un mensaje de error personalizado.
   }

   class ChatMessageHolder extends RecyclerView.ViewHolder {

      TextView tvUsername;
      TextView tvTime;
      TextView tvMessage;
      public ChatMessageHolder(@NonNull View itemView) {
         super(itemView);
         tvUsername = itemView.findViewById(R.id.tvUsername);
         tvTime = itemView.findViewById(R.id.tvTime);
         tvMessage = itemView.findViewById(R.id.tvMessage);
      }
   }

   @Override
   public int getItemCount() {
      return super.getItemCount();
   }
}
