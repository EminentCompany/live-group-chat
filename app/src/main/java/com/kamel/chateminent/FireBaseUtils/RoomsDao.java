package com.kamel.chateminent.FireBaseUtils;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.kamel.chateminent.Model.Room;

public class RoomsDao {

    public static void AddChatRoom(Room room,
                                   OnSuccessListener onSuccessListener,
                                   OnFailureListener onFailureListener){
       DatabaseReference roomNode= MyDataBase.getRoomsBranch()
                .push();
       room.setId(roomNode.getKey());
       roomNode.setValue(room)
               .addOnSuccessListener(onSuccessListener)
               .addOnFailureListener(onFailureListener);
    }
}
