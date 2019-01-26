package modelo;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class MyListModel implements ListModel {
	
	private ArrayList<String> al= new ArrayList<String>();

	
       // @Override
        public int getSize() {
            return al.size();
        }
       // @Override
        public Object getElementAt(int index) {
            return al.get(index);
        }
       
		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}
    }


