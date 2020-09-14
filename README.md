# SingleClick
Android某个view单击事件限制
## step 1 :
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
## step 2 :
```
dependencies {
	 implementation 'com.github.OOOOOldZhu:SingleClick:V1.0.0'
}
```
## How to use:

way 1 - - - - - - - - - - - - - - - - - - - -
```
public class Example1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        SingleClickInjecter.inject(Example1Activity.this);
    }

    // delay must be not null
    @SingleClick(value = R.id.btn_sigleclick, delay = 1000)
    public void btnClick(View view) {
        Toast.makeText(this, "1秒内不允许第二次点击", Toast.LENGTH_SHORT).show();
    }

}
```
way 2 - - - - - - - - - - - - - - - - - - - -
```
public class Example2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        //if "delayTime" params donot enter in ，then defult delaytiem is 1500ms
        findViewById(R.id.btn_sigleclick).setOnClickListener(new SingleClickListener(1000) {
            @Override
            public void onSingleClick(View v) {
                Toast.makeText(Example2Activity.this, "1秒内不允许第二次点击", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```
