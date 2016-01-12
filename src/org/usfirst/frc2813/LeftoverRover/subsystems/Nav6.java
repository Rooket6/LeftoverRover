package org.usfirst.frc2813.LeftoverRover.subsystems;

import org.usfirst.frc2813.LeftoverRover.IMU.IMU;
import org.usfirst.frc2813.LeftoverRover.IMU.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Nav6 extends Subsystem {
	
    public IMU imu;
    public IMUAdvanced imuAdvanced;
    
    public Nav6 () {
        SerialPort serial_port;
        try {
            serial_port = new SerialPort(57600,SerialPort.Port.kUSB);

            // You can add a second parameter to modify the
            // update rate (in hz) from 4 to 100.  The default is 100.
            // If you need to minimize CPU load, you can set it to a
            // lower value, as shown here, depending upon your needs.

            // You can also use the IMUAdvanced class for advanced
            // features.

            byte update_rate_hz = 100;
            imu = new IMU(serial_port, update_rate_hz);
            imuAdvanced = new IMUAdvanced(serial_port, update_rate_hz);
            System.out.println("imu init");
        } catch( Exception ex ) {
            System.out.println("Serial Port Exception");
            //If getting an exception make sure that Console out is unchecked on the imaging tool for the roborio
        }
        if ( imu != null ) {
            LiveWindow.addSensor("IMU", "Gyro", imu);
        }
    }
    public void initDefaultCommand() {
    }
    public double pidGet () {
        return imu.pidGet();
    }
    public float getYaw(){
        return imu.getYaw();
    }
    public boolean resetNav6() {
        boolean is_calibrating = imu.isCalibrating();
        if (!is_calibrating) {
            Timer.delay(0.3);
            imu.zeroYaw();
            return true;
        } else {
            return false;
        }

    }
    public void displayNav6Data () {
            SmartDashboard.putNumber("IMU_Yaw", imu.getYaw());
            SmartDashboard.putNumber("PIDget", imu.pidGet());
            SmartDashboard.putBoolean("IMU_IsCalibrating", imu.isCalibrating());
            SmartDashboard.putNumber("IMU_Pitch", imu.getPitch());
            SmartDashboard.putNumber("IMU_Roll", imu.getRoll());
            SmartDashboard.putNumber("IMU_CompassHeading", imu.getCompassHeading());
            SmartDashboard.putNumber("IMU_Update_Count", imu.getUpdateCount());
            SmartDashboard.putNumber("IMU_Byte_Count", imu.getByteCount());
            SmartDashboard.putNumber(   "IMU_Accel_X",          imuAdvanced.getWorldLinearAccelX());
            SmartDashboard.putNumber(   "IMU_Accel_Y",          imuAdvanced.getWorldLinearAccelY());
    }
}
