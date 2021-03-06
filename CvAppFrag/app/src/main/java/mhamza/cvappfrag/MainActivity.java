package mhamza.cvappfrag;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selectFrag(View view){
        Fragment fr;
        if(view==findViewById(R.id.intbtn))
        {
            fr= new Int_Frag();
        }
        else if (view==findViewById(R.id.qualbtn)){
            fr=new Qual_Frag();

        }
        else if (view==findViewById(R.id.Skills)){
            fr=new Skill_Frag();
        }
        else {
            fr=new Obj_Frage();
        }

        FragmentManager fm=getFragmentManager();
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place,fr);
        fragmentTransaction.commit();
    }
}
