/**
 * 
 */
package com.damontung.myfragment;

import com.damontung.myinterface.OnNewItemAddedListener;
import com.damontung.todolist.R;
import com.damontung.todolist.R.id;
import com.damontung.todolist.R.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * @author DamonTung
 * @date 2014��10��17��
 * @description
 */
@SuppressLint("NewApi")
public class NewItemFragment extends Fragment {
	private OnNewItemAddedListener onNewItemAddedListener;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.new_item_fragment, container, false);
		final EditText myEditText = (EditText) view.findViewById(R.id.myEditText);
		myEditText.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER)
							|| (keyCode == KeyEvent.KEYCODE_ENTER)) {
						String newItem = myEditText.getText().toString();
						onNewItemAddedListener.onNewItemAdded(newItem);
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});
		
		return view;
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onAttach(android.app.Activity)
	 */
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try {
			onNewItemAddedListener = (OnNewItemAddedListener)activity;
		} catch (ClassCastException e) {
			// TODO: handle exception
			throw new ClassCastException(activity.toString()+"must implement OnNewItemAddedListener");
		}
	}
	
}
