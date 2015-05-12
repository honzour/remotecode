package cz.honza.remotecode;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Interpreter i = new Interpreter();
		try
		{
			i.set("foo", 5);                    // Set variables
			i.set("date", new Date() ); 

			Date date = (Date)i.get("date");    // retrieve a variable

			// Eval a statement and get the result
			i.eval("bar = foo*10");
			i.eval("android.util.Log.e(\"baba\", \"baba\")");
			
			Toast.makeText(this, i.get("bar").toString(), Toast.LENGTH_LONG).show();
		}
		catch (EvalError e)
		{
			e.printStackTrace();
		}
	}

}
