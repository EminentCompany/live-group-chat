package com.kamel.chateminent.FireBaseUtils;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.kamel.chateminent.Model.Message;

import static com.kamel.chateminent.FireBaseUtils.MyDataBase.getMessagesBranch;

public class MessagesDao {

  public static void sendMessage(Message message,
                                 OnSuccessListener onSuccessListener,
                                 OnFailureListener onFailureListener){
     DatabaseReference messageNode=
            getMessagesBranch().push();
     message.setId(messageNode.getKey());
     messageNode.setValue(message)
             .addOnSuccessListener(onSuccessListener)
             .addOnFailureListener(onFailureListener);
    }

    public static Query getMessagesByRoomId(String roomId){

        Query query= getMessagesBranch()
                .orderByChild("roomId")
                .equalTo(roomId);
        return query;


    }

}
