package com.tw.server;
import java.io.File;
import java.io.IOException;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;

public class SoundEffects {
	private static String path = "wav\\download-complete.wav";
	public static void SoundEffects() {
		File f1 = new File(path);
		try {
			Player player = Manager.createRealizedPlayer(f1.toURI().toURL());
			player.prefetch();
			player.start();
		} catch (CannotRealizeException ex) {
		} catch (NoPlayerException ex) {
		} catch (IOException ex) {
		}
	}
}