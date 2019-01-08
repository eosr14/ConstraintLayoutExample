package constraintlayoutexample.eosr14.com.constraintlayoutexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_virtual_helpers_objects.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_virtual_helpers_objects)

        image1.setOnClickListener {
            // image1를 PlaceHolder에 적용
            Toast.makeText(this, "Image 1 Click", Toast.LENGTH_SHORT).show()
            place_holder.setContentId(R.id.image1)
        }

        image2.setOnClickListener {
            // image2를 PlaceHolder에 적용
            Toast.makeText(this, "Image 2 Click", Toast.LENGTH_SHORT).show()
            place_holder.setContentId(R.id.image2)
        }

        image3.setOnClickListener {
            // image3 뷰를 PlaceHolder에 적용
            Toast.makeText(this, "Image 3 Click", Toast.LENGTH_SHORT).show()
            place_holder.setContentId(R.id.image3)
        }

    }

}
