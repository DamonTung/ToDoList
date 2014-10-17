package com.damontung.todolist;

import java.util.ArrayList;

import com.damontung.myfragment.ToDoListFragment;
import com.damontung.myinterface.OnNewItemAddedListener;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnNewItemAddedListener{
	private ArrayAdapter<String> aaAdapter;
	private ArrayList<String> todoItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager fmManager = getFragmentManager();
		ToDoListFragment toDoListFragment = (ToDoListFragment) fmManager
				.findFragmentById(R.id.ToDoListFragment);
		todoItems = new ArrayList<String>();

		
		aaAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, todoItems);
		toDoListFragment.setListAdapter(aaAdapter);

	}

	@Override
	public void onNewItemAdded(String newItem) {
		// TODO Auto-generated method stub
		todoItems.add(newItem);
		aaAdapter.notifyDataSetChanged();
	}
}
