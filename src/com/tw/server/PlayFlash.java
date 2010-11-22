package com.tw.server;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import com.docuverse.swt.flash.FlashPlayer;
import com.docuverse.swt.flash.FlashPlayerListener;
 
public class PlayFlash implements FlashPlayerListener 
{  
   Shell shell;
   FlashPlayer player;
   
   private void createFlashApp() 
   {
      player = new FlashPlayer(shell, SWT.NONE, this);

      //this line loads the flash movie from disk
      player.loadMovie(0,"C:/8394799.swf");
      player.setSize(150, 150);
      player.activate();
    }

   /*
   public static void main (String [] args) {
      Display display = new Display();
      Shell shell = new SWTFlash_Example().open (display);
      
      while (!shell.isDisposed()) {
         if (!display.readAndDispatch()) display.sleep ();
       }
      display.dispose ();
    }
   */
   
   public Shell open (Display display) 
   {
      shell = new Shell (display, SWT.NO_TRIM | SWT.ON_TOP);
        
      //createMenuBar();
      createFlashApp();
      
      Monitor monitor = shell.getMonitor();
      Rectangle bounds = monitor.getBounds();
      Rectangle rect = shell.getBounds();
      
      int x = bounds.x + bounds.width-150;//- rect.width)/2;
      int y = bounds.y + bounds.height-150;// - rect.height)/2;
      
      shell.setLocation(x, y);
      shell.setSize(150, 200);
      shell.open();
          
      return shell;
    }
   
   public void onFSCommand(String param, String value) 
   {
      System.out.println("\nFSCommand:\nParam = " + param + "\nValue = " + value);
    }
   
   public void onReadyStateChange(int arg) {}
   public void onProgress(int arg) {}
}

