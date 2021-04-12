/**
 * 
 */
package spiservice;

/**
 * @author xiaoy
 *
 */
public class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mCpu;
    protected String mGpu;
    protected String mOs;

    public void setBoard(String board) {
        mBoard = board;
    }

    public void setDisplay(String display) {
        mDisplay = display;
    }

    public void setCpu(String cpu) {
        mCpu = cpu;
    }

    public void setGpu(String gpu) {
        mGpu = gpu;
    }

    public void setOs(String os) {
        mOs = os;
    }

    public static class Builder {
        Computer computer;

        public Builder() {
            computer = new Computer();
        }

        public Builder board(String board) {
            computer.setBoard(board);
            return this;
        }

        public Builder display(String display) {
            computer.setDisplay(display);
            return this;
        }

        public Builder cpu(String cpu) {
            computer.setCpu(cpu);
            return this;
        }

        public Builder gpu(String gpu) {
            computer.setGpu(gpu);
            return this;
        }

        public Builder os(String os) {
            computer.setOs(os);
            return this;
        }

        public Computer build() {
            return computer;
        }
    }
}


