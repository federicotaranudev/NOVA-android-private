package site.federicotaranu.nova;
import android.app.*;import android.os.*;import android.content.*;import android.net.Uri;import android.webkit.*;import java.util.concurrent.*;
public class BridgeRegression extends Instrumentation {
 public void onCreate(Bundle args){super.onCreate(args);start();}
 MainActivity a;String value;
 String evaluate(String script)throws Exception{CountDownLatch l=new CountDownLatch(1);runOnMainSync(()->a.web.evaluateJavascript(script,v->{value=v;l.countDown();}));if(!l.await(15,TimeUnit.SECONDS))throw new Exception("JS callback timeout");return value;}
 void shot(String name)throws Exception{Thread.sleep(1500);android.graphics.Bitmap b=getUiAutomation().takeScreenshot();java.io.FileOutputStream o=new java.io.FileOutputStream(new java.io.File(a.getExternalFilesDir(null),name));b.compress(android.graphics.Bitmap.CompressFormat.PNG,100,o);o.close();}
 public void onStart(){Bundle result=new Bundle();try{
 a=(MainActivity)startActivitySync(new Intent(getTargetContext(),MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
 Thread.sleep(18000);
 result.putString("webview",WebView.getCurrentWebViewPackage().versionName);
 result.putString("before",evaluate("JSON.stringify({ready:document.readyState,nat:typeof nat,dialogs:typeof HTMLDialogElement,ob:!document.getElementById('ob').hidden,uri:location.href})"));
 evaluate("window.__errs=[];window.addEventListener('error',e=>__errs.push(String(e.message)));S.introOff=1;S.done=1;S.ob=2;S.name='Synthetic Android';S.prof.username='synthetic.test';document.body.classList.remove('ovl','ovli');document.getElementById('ob').hidden=true;document.getElementById('intro')?.remove();webkit.messageHandlers.nova.postMessage({t:'intro',stop:true});window.__bridgeResult=null;(async()=>{try{const ai=await nat('groq','set',{key:'invalid-synthetic'});const cv=await nat('classeviva','login',{uid:'',pass:''});const has=await nat('groq','has');window.__bridgeResult={ok:ai.err==='formato'&&cv.err==='dati'&&has.ok===1,ai:ai.err,school:cv.err}}catch(e){window.__bridgeResult={error:String(e)}}})();true");
 String r="null";for(int n=0;n<150;n++){r=evaluate("JSON.stringify(window.__bridgeResult)");if(!r.equals("\"null\"")&&!r.equals("null"))break;Thread.sleep(1000);}
 result.putString("regression",r);
 result.putString("open",evaluate("(()=>{try{document.querySelectorAll('dialog[open]').forEach(d=>d.close());sheet();document.getElementById('dSet').showModal();const k=document.querySelector('.gqK');k.value='invalid-synthetic';document.querySelector('.gqS').click();k.scrollIntoView({block:'center'});return 'opened'}catch(e){return String(e)}})()"));
 Thread.sleep(1500);result.putString("dom",evaluate("JSON.stringify({errors:window.__errs,ob:!document.getElementById('ob').hidden,dialogs:[...document.querySelectorAll('dialog')].map(d=>({id:d.id,open:d.open,display:getComputedStyle(d).display,background:getComputedStyle(d).backgroundColor,position:getComputedStyle(d).position,rect:{top:d.getBoundingClientRect().top,bottom:d.getBoundingClientRect().bottom}})),viewport:{w:innerWidth,h:innerHeight},cssMin:CSS.supports('width','min(460px, 90vw)'),cssDvh:CSS.supports('height','100dvh')})"));
 shot("native.png");
 evaluate("document.querySelector('.gqK').focus();true");runOnMainSync(()->{a.web.requestFocus();((android.view.inputmethod.InputMethodManager)a.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(a.web,android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT);});shot("keyboard.png");
 finish(r.contains("\\\"ok\\\":true")?Activity.RESULT_OK:Activity.RESULT_CANCELED,result);
 }catch(Exception e){result.putString("error",e.toString());finish(Activity.RESULT_CANCELED,result);}}
}
