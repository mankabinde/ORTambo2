package com.example.admin.ortambo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;


public class ViewingDeckFragment extends Fragment {
  private ListView mORtamboListView;
  private  ORtamboAdapter mORtamboAdapter;
  private DatabaseReference mDatabaseReference;
  private FirebaseDatabase tFirebaseDatabase;
  private ChildEventListener mChildEventListener;
  FirebaseStorage tFirebaseStorage;

  private ArrayList<String> list = new ArrayList<>();
  private ListView sListView;

  ArrayAdapter<String> adapter;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.list, container, false);

    tFirebaseDatabase = FirebaseDatabase.getInstance();
    tFirebaseStorage = FirebaseStorage.getInstance();

    mDatabaseReference = tFirebaseDatabase.getReference().child("Viewing_Deck");

    mORtamboListView = rootView.findViewById(R.id.mlist);
    List<ORtambo> ORtambo = new ArrayList<>();
    mORtamboAdapter = new ORtamboAdapter(getActivity(), R.layout.hotel_list, ORtambo);
    mORtamboListView.setAdapter(mORtamboAdapter);

    mChildEventListener = new ChildEventListener() {
      @Override
      public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        ORtambo value = dataSnapshot.getValue(ORtambo.class);
        mORtamboAdapter.add(value);

      }

      @Override
      public void onChildChanged(DataSnapshot dataSnapshot, String s) {

      }

      @Override
      public void onChildRemoved(DataSnapshot dataSnapshot) {


      }

      @Override
      public void onChildMoved(DataSnapshot dataSnapshot, String s) {

      }

      @Override
      public void onCancelled(DatabaseError databaseError) {


      }

    };

    mDatabaseReference.addChildEventListener(mChildEventListener);
    return rootView;
  }}