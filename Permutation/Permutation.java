package github.com.dongkwanpark;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		
		// nPr
		int r = 4;
		int[] n = { 5,7,2,4,9,8 };
		Solution solution = new Solution();
		solution.perMutation( n, r );
		System.out.println( "Permutation Count : " + solution.getCount() );
	}

}

class Data {
	
	List<Integer> datalist = new ArrayList<Integer>();
	
	Data(int[] data) {
		int count = data.length;
		for( int i = 0; i < count; i++ )
			datalist.add( data[i] );
	}
	Data(int[] data, int[] index) {
		int count = index.length;
		for( int i = 0; i < count; i++ ) {
			if( data.length > index[i] )
				datalist.add( data[index[i]] );	
		}	
	}
	
	public void show() {
		for( int i = 0; i < datalist.size(); i++ ) {
			Integer value = datalist.get( i );
			System.out.print( value + " " );
		}
		System.out.println( "" );
	}
}

class Solution {
	
	List<Data> result = new ArrayList<Data>();
	
	public void perMutation(int[] input, int count) {
		
		int position = 0;
		int[] indexdata = new int[ count ];
		indexdata[ position ] = -1;  
		
		while( true ) {
			if( indexdata[ position ] + 1 < input.length ) {
				for( int value = indexdata[ position ]; value < input.length; value++ ) {					
					boolean add = true;
					for( int index = 0; index <= position; index++ ) {
						if( indexdata[ index ] == value ) {
							add = false;
							break;
						}	
					}
					if( add ) {
						indexdata[ position ] = value;
						if( position == count - 1 ) {
							Data data = setData( input, indexdata );
							data.show();
						} else {
							position += 1;
							value = -1;
						}
					}
				}
			}
			indexdata[ position ] = -1;
			position -= 1;
			if( position < 0 )
				break;
		}
	}
	
	private Data setData(int[] input, int[] indexdata) {
		Data data = new Data( input, indexdata );
		result.add( data );
		return data;
	}
	
	public int getCount() {
		return result.size();
	}
}



