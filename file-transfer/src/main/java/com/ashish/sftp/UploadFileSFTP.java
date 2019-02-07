package com.ashish.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class UploadFileSFTP {
	 
	 public static void main(String[] args) throws Exception {

	  JSch jsch = new JSch();
	        Session session = null;
	        try {
	            session = jsch.getSession("test", "localhost", 22222);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.setPassword("clean-unencripted-password");
	            session.connect();
	            
	            Channel channel = session.openChannel("sftp");
	            channel.connect();
	            ChannelSftp sftpChannel = (ChannelSftp) channel;
	            sftpChannel.put("C:/Users/reyaj.ahmed/Downloads/*.zip", "C:/Users/reyaj.ahmed/Ashis_Assignment/sftp-server/ServerHome/");  
	            sftpChannel.exit();
	            session.disconnect();
	        } catch (JSchException e) {
	            e.printStackTrace();  
	        } catch (SftpException e) {
	            e.printStackTrace();
	        }

	 }

	}