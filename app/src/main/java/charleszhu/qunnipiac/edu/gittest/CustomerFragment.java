package charleszhu.qunnipiac.edu.gittest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/*
 * Created by Charles
 * A simple {@link Fragment} subclass.
 * Customer fragment directs customer user to make and view reservation activities.
 */
public class CustomerFragment extends Fragment {
    
    static interface CustomerFragmentListener{
        void onCustomerClick(View view);
    }
    private CustomerFragment.CustomerFragmentListener listener;


    public CustomerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //attach listener so that the activity can implement onClick method
        this.listener = (CustomerFragment.CustomerFragmentListener)activity;
    }

    public void onCustomerClick(View view){

        if(view.getId()==R.id.view_button){
            //starts the View Reservation Activity
            startActivity(new Intent(getActivity(),ViewReservationActivity.class));
        }

        if(view.getId()==R.id.add_button){
            //starts the Add Reservation Activity
            startActivity(new Intent(getActivity(), MakeReservationActivity.class));
        }
        
    }

}
