package com.example.bepresent.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.example.bepresent.R;
import com.example.bepresent.calendar.DatePickerConcrete;
import com.example.bepresent.database.friends.Friend;
import com.example.bepresent.database.friends.FriendRepository;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Date;
import java.util.List;

public class AddFriendFragment extends Fragment {
    private Button dateButton;
    private DatePickerConcrete datePicker;
    private EditText name;
    private EditText surname;
    private CheckBox isCloseFriend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_friend, container, false);
        // init all values
        datePicker = new DatePickerConcrete();
        dateButton = view.findViewById(R.id.datePickerButton);
        datePicker.init(requireContext(), dateButton);
        name = view.findViewById(R.id.editTextName);
        surname = view.findViewById(R.id.editTextSurname);
        isCloseFriend = view.findViewById(R.id.checkBoxCloseFriend);

        Button addFriend = view.findViewById(R.id.buttonAddFriend);


        addFriend.setOnClickListener(view2 -> addNewFriend());




        return view;

    }

    private void addNewFriend() {

        FriendRepository friendTable = FriendRepository.getInstance();

        Friend friend = new Friend(name.getText().toString(),surname.getText().toString(),
                            datePicker.getDate(), isCloseFriend.isChecked());

        friendTable.insertFriend(friend);


        List<Friend> friends = friendTable.getAllFriends();
        for (Friend f : friends) {
            Log.d("MYboiDB", "User: " + f.getBirthday().toString() + " " + f.getLastName());
        }

        friends = friendTable.getFriendByBirthday(datePicker.getDate());
        for (Friend f : friends) {
            Log.d("MYboiDB", "THIS SHIT HARD: " + f.getBirthday().toString() + " " + f.getLastName());
        }



    }


}