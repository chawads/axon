package org.zigmoi.axon.commons.filemotion.core.local;

/**
 * Created by Zigmoi-Code on 3/1/2015.
 */
public class FMotionModel {

    String srcFile;
    String destFile;

    int motionMode;

    boolean createDestParentDir;
    boolean overwriteFiles;

    long totalTimeTaken;
    boolean destFileExists;

    boolean successful;
    String errorMsg;
}