package com.example.todolist;

import java.util.ArrayList;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText myEditText = (EditText) findViewById(R.id.myEditText);
		ListView myListView = (ListView) findViewById(R.id.myListView);

		final ArrayList<String> toDoItems = new ArrayList<String>();
		final ArrayAdapter<String> aaAdapter = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, toDoItems);

		myListView.setAdapter(aaAdapter);

		myEditText.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
						toDoItems.add(myEditText.getText().toString());
						aaAdapter.notifyDataSetChanged();
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});
	}
}
