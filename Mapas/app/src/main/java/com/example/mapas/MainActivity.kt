package com.example.mapas

import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private lateinit var map:GoogleMap

    companion object{
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()
    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment =supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        //createMarker()
        createPolylines()
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableLocation()
    }

    private fun createPolylines(){
        val polylineOptions = PolylineOptions()
            .add(LatLng(-11.992827597722862, -76.83711235277528))
            .add(LatLng(-11.993541233944466, -76.83870022041931))
            .add(LatLng(-11.995692339185602, -76.84019297954104))
            .add(LatLng(-11.998163406822515, -76.84098402560183))
            .add(LatLng(-12.001283409364678, -76.84274474102747))
            .add(LatLng(-12.005252000429511, -76.84769515845277))
            .add(LatLng(-12.006400135395237, -76.85632011286742))
            .add(LatLng(-12.007735460095418, -76.86577438995309))
            .add(LatLng(-12.00813480825097, -76.86895133300368))
            .add(LatLng(-12.009694756346248, -76.87681075895976))
            .add(LatLng(-12.012015942392773, -76.88783436924017))
            .add(LatLng(-12.013076692785537, -76.89261892231806))
            .add(LatLng(-12.013575867995131, -76.89594897131957))
            .add(LatLng(-12.013975207490109, -76.89764589270804))
            .add(LatLng(-12.01439950505452, -76.8994193669411))
            .add(LatLng(-12.019640772908964, -76.90861846763873))
            .add(LatLng(-12.01996522904391, -76.90976676067818))
            .add(LatLng(-12.021575024548547, -76.91498511291793))
            .add(LatLng(-12.021799646454918, -76.91568684773156))
            .add(LatLng(-12.022735568864904, -76.92077761189698))
            .add(LatLng(-12.023361916178507, -76.92394792709499))
            .add(LatLng(-12.02244898228307, -76.93547069711134))
            .add(LatLng(-12.022669345909325, -76.9358140198715))
            .add(LatLng(-12.022553917356696, -76.9392901627442))
            .add(LatLng(-12.022774280895794, -76.939880248693))
            .add(LatLng(-12.022627371889786, -76.94038450395833))
            .add(LatLng(-12.022784774396332, -76.94108187836055))
            .add(LatLng(-12.022837241876998, -76.94275557668804))
            .add(LatLng(-12.022847735378782, -76.94323837447057))
            .add(LatLng(-12.023089085648612, -76.94440781753272))
            .add(LatLng(-12.02352456494093, -76.94643020324122))
            .add(LatLng(-12.023797394978345, -76.94712221312663))
            .add(LatLng(-12.023991523874946, -76.94727241682268))
            .add(LatLng(-12.024059731291842, -76.94747626469591))
            .add(LatLng(-12.024002017324813, -76.94780081196774))
            .add(LatLng(-12.024083341551705, -76.94815218138696))
            .add(LatLng(-12.024222379681914, -76.9484633176145))
            .add(LatLng(-12.024256483363258, -76.94871544524717))
            .add(LatLng(-12.024385027969469, -76.94898098392413))
            .add(LatLng(-12.024406014846456, -76.94917142081609))
            .add(LatLng(-12.024392898053739, -76.94923713493311))
            .add(LatLng(-12.024358794389684, -76.9492733447527))
            .add(LatLng(-12.02429583376778, -76.94927736806598))
            .add(LatLng(-12.02423680817136, -76.94930687236342))
            .add(LatLng(-12.024214509609335, -76.949361857645))
            .add(LatLng(-12.024205327847966, -76.94942086623989))
            .add(LatLng(-12.024239431531472, -76.94949999140121))
            .add(LatLng(-12.024270911851584, -76.94957106994647))
            .add(LatLng(-12.02432731408129, -76.9496408073768))
            .add(LatLng(-12.024370599505364, -76.94976821229756))
            .add(LatLng(-12.024421754998851, -76.94986208962393))
            .add(LatLng(-12.024438806827419, -76.95003911540856))
            .add(LatLng(-12.024400768128633, -76.95014908599235))
            .add(LatLng(-12.02435354767096, -76.95022284673595))
            .add(LatLng(-12.024207951207595, -76.95032477067257))
            .add(LatLng(-12.024158107355177, -76.95039853141617))
            .add(LatLng(-12.024173847517906, -76.95042937684305))
            .add(LatLng(-12.02435485934914, -76.95098861741202))
            .add(LatLng(-12.024419131636398, -76.9513426689874))
            .add(LatLng(-12.024440118502675, -76.95150628374574))
            .add(LatLng(-12.024489962302827, -76.95159881995136))
            .add(LatLng(-12.024652610431852, -76.95172086046371))
            .add(LatLng(-12.024688025736518, -76.9518080322516))
            .add(LatLng(-12.02470376587211, -76.95202126788155))
            .add(LatLng(-12.024744427880437, -76.95235117958418))
            .add(LatLng(-12.024869037225828, -76.95255100415983))
            .add(LatLng(-12.02500938662623, -76.95271327779574))
            .add(LatLng(-12.025085463840691, -76.9527803330172))
            .add(LatLng(-12.025170722762375, -76.95281922504564))
            .add(LatLng(-12.025259916697355, -76.95281386066186))
            .add(LatLng(-12.025433057751568, -76.9527468054404))
            .add(LatLng(-12.02549339475942, -76.95274009991826))
            .add(LatLng(-12.025570783510554, -76.95275216985812))
            .add(LatLng(-12.025641613873432, -76.95285543489916))
            .add(LatLng(-12.025780651198172, -76.9529721109845))
            .add(LatLng(-12.02592887015388, -76.95305458890688))
            .add(LatLng(-12.026355818999717, -76.95318400549024))
            .add(LatLng(-12.026693573751434, -76.95336438404568))
            .add(LatLng(-12.026830643038362, -76.9534817306982))
            .add(LatLng(-12.026925083075648, -76.95365339206512))
            .add(LatLng(-12.027004438917844, -76.95375598656958))
            .add(LatLng(-12.027296284570713, -76.95389143811691))
            .add(LatLng(-12.027447126025086, -76.95406712280563))
            .add(LatLng(-12.027544189177496, -76.95425554799232))
            .add(LatLng(-12.028216416115795, -76.95473365174539))
            .add(LatLng(-12.028859784913118, -76.955130618688))
            .add(LatLng(-12.029301813138293, -76.9553297727026))
            .add(LatLng(-12.02929722234447, -76.95533111380703))
            .add(LatLng(-12.028814509458737, -76.9523771061514))
            .add(LatLng(-12.027424653536338, -76.94397195093367))
            .add(LatLng(-12.027561919489683, -76.94392091570393))
            .add(LatLng(-12.027605595005612, -76.94388263928164))
            .add(LatLng(-12.027761578933116, -76.94389539808907))
            .add(LatLng(-12.02803611042579, -76.94378694822589))
            .add(LatLng(-12.028167136721212, -76.9435190132698))
            .add(LatLng(-12.028279444923472, -76.94281089938613))
            .add(LatLng(-12.029580951671738, -76.94283556671503))
            .add(LatLng(-12.029799836747484, -76.94280522096743))
            .add(LatLng(-12.02991855399265, -76.94274452950911))
            .add(LatLng(-12.030690214808462, -76.94253590262117))
            .add(LatLng(-12.030834900964852, -76.94282798026428))
            .add(LatLng(-12.030931658662311, -76.94337779190806))
            .add(LatLng(-12.03233917238675, -76.94300810369339))
            .add(LatLng(-12.033537460878117, -76.94257188382488))
            .add(LatLng(-12.033856508933653, -76.94242394837693))
            .add(LatLng(-12.034672676632923, -76.94206359282462))
            .add(LatLng(-12.035564893490651, -76.94166151189505))
            .add(LatLng(-12.03597297504881, -76.94147754091205))
            .add(LatLng(-12.037846432475027, -76.94063544685324))
            .add(LatLng(-12.039938753621513, -76.9396814529478))
            .add(LatLng(-12.03984971901221, -76.93940075495311))
            .add(LatLng(-12.041765811530723, -76.9386326285988))
            .add(LatLng(-12.043010429631662, -76.93813382065068))
            .add(LatLng(-12.043785762586502, -76.93781139726076))
            .add(LatLng(-12.045709246416049, -76.94263636849082))
            .add(LatLng(-12.050735002643352, -76.955228493414))
            .add(LatLng(-12.050922338671437, -76.95570074882397))
            .add(LatLng(-12.054183038693001, -76.96337583632662))
            .add(LatLng(-12.056179093055174, -76.968060291721))
            .add(LatLng(-12.060423127574827, -76.97776142452791))
            .add(LatLng(-12.060951729618132, -76.97881404204286))
            .add(LatLng(-12.062150961606527, -76.980523846157))
            .add(LatLng(-12.062874306849029, -76.9815935331477))
            .add(LatLng(-12.063082036406536, -76.98199561408924))
            .add(LatLng(-12.063202356732772, -76.9824765475934))
            .add(LatLng(-12.063285819416837, -76.98299242502848))
            .add(LatLng(-12.063391538779348, -76.98364296159723))
            .add(LatLng(-12.063491693928155, -76.98419108138133))
            .add(LatLng(-12.063789751344933, -76.9858464263429))
            .add(LatLng(-12.064041993491431, -76.98717405204658))
            .add(LatLng(-12.071143184206775, -76.98889799493587))
            .add(LatLng(-12.07136759938227, -76.98889799493587))
            .add(LatLng(-12.071579031689682, -76.98887333903092))
            .add(LatLng(-12.071556775674345, -76.98886385598958))
            .add(LatLng(-12.071873923854346, -76.98876523236042))
            .add(LatLng(-12.072387666007158, -76.98854143260792))
            .add(LatLng(-12.072808674209105, -76.98933231823736))
            .add(LatLng(-12.074138808327783, -76.99181525028234))
            .add(LatLng(-12.076987537018763, -76.98959052888918))
            .add(LatLng(-12.079661901884633, -76.9875080531013))
            .add(LatLng(-12.080227558163688, -76.98706045356627))
            .add(LatLng(-12.082095142672532, -76.98558109920693))
            .add(LatLng(-12.083243135047379, -76.98468779673362))
            .add(LatLng(-12.083623325285632, -76.98439192587438))
            .add(LatLng(-12.083920058754847, -76.98421743793172))
            .add(LatLng(-12.084179700277963, -76.98413778037893))
            .add(LatLng(-12.085051352111751, -76.98397846528064))
            .add(LatLng(-12.085005741348345, -76.98211754055384))
            .add(LatLng(-12.084647808012235, -76.98193356957086))
            .add(LatLng(-12.083609242228418, -76.9808543994722))
            .add(LatLng(-12.083190105620538, -76.98040679996717))
            .add(LatLng(-12.082973118704546, -76.98018679341568))
            .add(LatLng(-12.082626310195263, -76.97982074803747))
            .add(LatLng(-12.081973492951436, -76.97913607246235))
            .add(LatLng(-12.08100724633635, -76.97813087013473))
            .add(LatLng(-12.08102022855939, -76.97812707691858))
            .add(LatLng(-12.080571414197331, -76.9776434418602))
            .add(LatLng(-12.079785059925902, -76.97700618147711))
            .add(LatLng(-12.07905990572187, -76.97650927014958))
            .add(LatLng(-12.077937860170042, -76.97596115039418))
            .add(LatLng(-12.077635785692205, -76.97582643740213))
            .add(LatLng(-12.076458027248883, -76.97530993706182))
            .add(LatLng(-12.075868043312127, -76.97505619782743))
            .add(LatLng(-12.073902891169357, -76.97419799530735))
            .add(LatLng(-12.07298647692013, -76.97379877890606))
            .add(LatLng(-12.071417206711976, -76.97317288875307))
            .add(LatLng(-12.070545998629596, -76.97283005884769))
            .add(LatLng(-12.067687339987405, -76.9717172775343))
            .add(LatLng(-12.067226365598831, -76.97055458795715))
            .add(LatLng(-12.06707969176057, -76.9701993529969))
            .add(LatLng(-12.06669922166316, -76.96942121933965))
            .add(LatLng(-12.066019888190665, -76.96850663030632))
            .add(LatLng(-12.065672501100675, -76.96803975012487))
            .add(LatLng(-12.065541265857275, -76.96767774879007))
            .add(LatLng(-12.065464068621996, -76.96738453897821))
            .add(LatLng(-12.065024043978388, -76.9661711015407))
            .add(LatLng(-12.062394140839682, -76.95955325908481))
            .add(LatLng(-12.062104096295071, -76.95862964825558))
            .add(LatLng(-12.061862822990301, -76.9564873723054))
            .add(LatLng(-12.061708637140747, -76.95510765628423))
            .add(LatLng(-12.061657906808504, -76.95466896932848))
            .add(LatLng(-12.061492481748157, -76.95388519700646))
            .add(LatLng(-12.061137616176953, -76.95296697176308))
            .add(LatLng(-12.060141238108764, -76.95087813398553))
            .add(LatLng(-12.05964826833398, -76.94985979381656))
            .add(LatLng(-12.059317415629986, -76.9491865390413))
            .add(LatLng(-12.058105386566893, -76.94682878346515))
            .add(LatLng(-12.056903314220424, -76.94449187649052))
            .add(LatLng(-12.060218326284108, -76.94252790790313))
            .add(LatLng(-12.06103663181533, -76.94205087813242))
            .add(LatLng(-12.06496333667822, -76.93971456276614))
            .add(LatLng(-12.064399413232438, -76.93759602892234))
            .add(LatLng(-12.064015591229149, -76.93623356255154))
            .add(LatLng(-12.0640352635151, -76.93596668277013))
            .add(LatLng(-12.063925098694291, -76.93547449740133))
            .add(LatLng(-12.063963131792171, -76.93529210717676))
            .add(LatLng(-12.063864770319656, -76.93485088378226))
            .add(LatLng(-12.063797884498962, -76.93438015612766))
            .add(LatLng(-12.063957755147658, -76.93400956946262))
            .add(LatLng(-12.064004947753661, -76.93325954465847))
            .add(LatLng(-12.064204293525817, -76.9327257850957))
            .add(LatLng(-12.06433157516978, -76.9301351746089))
            .add(LatLng(-12.064262066493052, -76.92871494495252))
            .add(LatLng(-12.064118330203481, -76.92545232393933))
            .add(LatLng(-12.06411505184678, -76.92076980201617))
            .add(LatLng(-12.064121609273261, -76.92008717984832))
            .add(LatLng(-12.063490862169163, -76.9148985997452))
            .add(LatLng(-12.061729538128013, -76.90888990701333))
            .add(LatLng(-12.06238092450329, -76.9002428393711))
            .add(LatLng(-12.06165275605064, -76.8966535849759))
            .add(LatLng(-12.06236730842949, -76.89266675306799))
            .add(LatLng(-12.055388689021827, -76.87992556965841))
            .add(LatLng(-12.053130987225979, -76.8757930044018))
            .add(LatLng(-12.051644598720475, -76.8730588435737))
            .add(LatLng(-12.050419700140035, -76.87083188464891))
            .add(LatLng(-12.040559561747429, -76.85279915853877))
            .add(LatLng(-12.03905340160271, -76.85005423726813))
            .add(LatLng(-12.036975034440687, -76.8466204346998))
            .add(LatLng(-12.036161240065187, -76.84038463171274))
            .add(LatLng(-12.03661226793068, -76.83543727509269))
            .add(LatLng(-12.03952400397038, -76.83043917614535))
            .add(LatLng(-12.04335332998867, -76.82847241518773))
            .add(LatLng(-12.042691457477213, -76.82404249944882))
            .add(LatLng(-12.040326805124792, -76.81646415412236))
            .add(LatLng(-12.037967652568302, -76.80787447164204))
            .add(LatLng(-12.01826050069342, -76.79055131213498))
            .add(LatLng(-12.009665697244317, -76.78858455116895))
            .add(LatLng(-12.004918142084955, -76.78890933738212))
            .add(LatLng(-12.00294144017652, -76.79017239487784))
            .add(LatLng(-12.002906141661835, -76.7902265261876))
            .add(LatLng(-11.999782216710052, -76.7937450434971))
            .add(LatLng(-11.999012018309783, -76.80275626486551))
            .add(LatLng(-11.996152792860903, -76.80658152470967))
            .add(LatLng(-11.995482105864852, -76.80889111584686))
            .add(LatLng(-11.99604689494938, -76.8119044104502))
            .add(LatLng(-12.000229827328193, -76.81816556725498))
            .add(LatLng(-12.00000038546626, -76.82078190063896))
            .add(LatLng(-11.999259110382843, -76.82267648723574))
            .add(LatLng(-11.998288389982914, -76.8254191263693))
            .add(LatLng(-11.998306039475922, -76.82688066432863))
            .add(LatLng(-11.997017623449393, -76.82872111953667))
            .add(LatLng(-11.997070572163501, -76.8291722117325))
            .add(LatLng(-11.996258690568665, -76.83025483244312))
            .add(LatLng(-11.996311639442846, -76.83159006465287))
            .add(LatLng(-11.995058513298517, -76.83222159340075))
            .add(LatLng(-11.99569292648678, -76.83361020572954))
            .add(LatLng(-11.996566538843418, -76.83480315422445))
            .add(LatLng(-11.992827597722862, -76.83711235277528))
            .width(5f)
            .color(ContextCompat.getColor(this, R.color.kotlin))


        val polyline = map.addPolyline(polylineOptions)

        polyline.startCap = RoundCap()
        polyline.endCap = RoundCap()

        val pattern = listOf(
            Dash(3f), Gap(3f)
        )
        polyline.pattern = pattern
    }

    private fun createMarker() {
        val coordinates = LatLng(-11.988255982476637, -76.83963406747452)
        val marker = MarkerOptions().position(coordinates).title("Universidad Unión")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        this,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun enableLocation(){
        if (!::map.isInitialized) return
        if(isLocationPermissionGranted()){
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            map.isMyLocationEnabled = true
        }else{
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this, "Ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            REQUEST_CODE_LOCATION)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                if (ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                map.isMyLocationEnabled = true
            }else{
                Toast.makeText(this, "Para activar la localización ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::map.isInitialized) return
        if (!isLocationPermissionGranted()){
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            map.isMyLocationEnabled = false
            Toast.makeText(this, "Para activar la localización ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "Botón pulsado", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Estás en ${p0.latitude}, ${p0.longitude}", Toast.LENGTH_SHORT).show()
    }
}