package com.gl.club.common.tools;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
public class TranscodeUtil {

	/**
	 * avi转MP4
	 * @param sourcePath
	 * @param targetPath
	 */
	public static void changeAviToMp4(String sourcePath, String targetPath) {
		File source = new File(sourcePath);
		File target = new File(targetPath);
		AudioAttributes audio = new AudioAttributes();//
		audio.setCodec("libfaac");
		audio.setBitRate(new Integer(64000));//比特率
		audio.setChannels(new Integer(1));	//渠道
		audio.setSamplingRate(new Integer(22050));//取样频率
		VideoAttributes video = new VideoAttributes();//
		video.setCodec("mpeg4");
		video.setBitRate(new Integer(160000));
		video.setFrameRate(new Integer(15));
		video.setSize(new VideoSize(400, 300));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp4");
		attrs.setAudioAttributes(audio);
		attrs.setVideoAttributes(video);
		Encoder encoder = new Encoder();
		try {
			encoder.encode(source, target, attrs);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * amr转MP3
	 * @param sourcePath
	 * @param targetPath
	 */
	public static void changeAmrToMp3(String sourcePath, String targetPath) {
		File source = new File(sourcePath);
		File target = new File(targetPath);
		AudioAttributes audio = new AudioAttributes();
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setCodec("libmp3lame");
		audio.setSamplingRate(new Integer(44100));

		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		Encoder encoder = new Encoder();

		try {
			encoder.encode(source, target, attrs);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}
	
	public static int mp3DoingTime(File file) {
		MP3File f = null;
		try {
			f = (MP3File)AudioFileIO.read(file);
		} catch (CannotReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
		int i = audioHeader.getTrackLength();	
		return i;
	}
	
}
