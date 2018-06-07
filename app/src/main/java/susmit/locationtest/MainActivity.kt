package susmit.locationtest

import android.Manifest
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.PermissionChecker
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var tv2:TextView?=null
    var tv1:TextView?=null
    var lManager:LocationManager?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        




        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        lManager=getSystemService(Context.LOCATION_SERVICE)as LocationManager





        lManager?.getLastKnownLocation(
                LocationManager.NETWORK_PROVIDER)
        lManager?.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                1000.toLong(),1f, object :LocationListener {


            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderEnabled(provider: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderDisabled(provider: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onLocationChanged(location: Location?) {
                tv1?.text=location?.latitude.toString()
                tv2?.text=location?.longitude.toString()
                lManager?.removeUpdates(this)
            }


        }
        )






    }
}
