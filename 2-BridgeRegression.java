package site.federicotaranu.nova;
import android.app.*;import android.os.*;import android.content.*;import android.net.Uri;import android.webkit.*;import java.util.concurrent.*;
public class BridgeRegression extends Instrumentation {
 public void onCreate(Bundle args){super.onCreate(args);start();}
 MainActivity a;String value;
 String evaluate(String script)throws Exception{CountDownLatch l=new CountDownLatch(1);runOnMainSync(()->a.web.evaluateJavascript(script,v->{value=v;l.countDown();}));if(!l.await(15,TimeUnit.SECONDS))throw new Exception("JS callback timeout");return value;}
 public void onStart(){Bundle result=new Bundle();try{
 Intent i=new Intent(getTargetContext(),MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);a=(MainActivity)startActivitySync(i);
 Thread.sleep(3000);
 evaluate("window.__nativeOrigin=null;window.addEventListener('message',e=>{if(e.data==='probe-origin')window.__nativeOrigin=e.origin});true");
 runOnMainSync(()->a.web.postWebMessage(new WebMessage("probe-origin"),Uri.parse("https://appassets.androidplatform.net")));Thread.sleep(500);
 evaluate("window.__bridgeResult=null;(async()=>{try{const ai=await nat('groq','set',{key:'invalid-synthetic'});const cv=await nat('classeviva','login',{uid:'',pass:''});const has=await nat('groq','has');window.__bridgeResult={ok:ai.err==='formato'&&cv.err==='dati'&&has.ok===1,ai:ai.err,school:cv.err,origin:window.__nativeOrigin};sheet();document.querySelectorAll('dialog[open]').forEach(d=>d.close());document.getElementById('ob').hidden=true;if(document.getElementById('intro'))document.getElementById('intro').remove();document.body.classList.remove('ovl');document.getElementById('dSet').showModal();const k=document.querySelector('.gqK');if(k){k.value='invalid-synthetic';document.querySelector('.gqS').click();k.scrollIntoView({block:'center'})}}catch(e){window.__bridgeResult={ok:false,error:String(e)}}})();true");
 String r="null";for(int n=0;n<45;n++){r=evaluate("JSON.stringify(window.__bridgeResult)");if(!r.equals("\"null\"")&&!r.equals("null"))break;Thread.sleep(1000);}result.putString("regression",r);finish(r.contains("\\\"ok\\\":true")?Activity.RESULT_OK:Activity.RESULT_CANCELED,result);
 }catch(Exception e){result.putString("error",e.toString());finish(Activity.RESULT_CANCELED,result);}}
}
