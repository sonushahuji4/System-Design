/** Interface Segregation Principle (ISP) */

/** It emphasizes that clients should not be forced to depend on interfaces they do not use. 
 * In other words, a class should not be forced to implement interfaces that contain methods it does not need. */

/**
 * Understanding ISP:
The main idea behind ISP is to prevent "fat" interfaces, which contain more methods than a class needs, 
leading to unnecessary dependencies and potential issues such as code bloat and coupling.
 */

 /** Example:
Let's consider an example of a multimedia player interface. Initially, we may have a single interface that covers all possible actions a player can perform: */

public interface MediaPlayer {
    void playAudio();
    void playVideo();
    void pause();
    void stop();
    void rewind();
    void forward();
}

/**
 * However, not all types of players (e.g., audio player, video player) need to support all of these actions. 
 * For instance, an audio player may not support video-related actions like playVideo(), rewind(), and forward().
 */

 /**
  * Issue:
If we force all classes that represent multimedia players to implement this single interface, 
even if they don't use all the methods, we violate the ISP. This can lead to unnecessary complexity and potential errors.
  */

/**
 * Solution:
To adhere to the ISP, we should split the fat interface into smaller, more specialized interfaces that represent specific functionalities. 
This way, classes can implement only the interfaces that are relevant to them, reducing unnecessary dependencies.
 */

 public interface AudioPlayer {
    void playAudio();
    void pause();
    void stop();
}

public interface VideoPlayer {
    void playVideo();
    void pause();
    void stop();
    void rewind();
    void forward();
}

// Implementation for an audio player
public class BasicAudioPlayer implements AudioPlayer {
    // Implement methods
}

// Implementation for a video player
public class BasicVideoPlayer implements VideoPlayer {
    // Implement methods
}

/**
 * Now, classes can implement only the interfaces that are relevant to them. 
 * This reduces unnecessary dependencies and ensures that classes are not forced to implement methods they do not need, adhering to the Interface Segregation Principle.
 */

 /**
  * Summary:
The Interface Segregation Principle advocates for creating interfaces that are focused and tailored to specific client needs. 
By avoiding "fat" interfaces and breaking them down into smaller, specialized interfaces, we can reduce dependencies, improve maintainability, and adhere to the SOLID principles.
  */




  /**
   * 1. Understanding ISP:
ISP states that clients should not be forced to depend on interfaces they do not use. 
This means that interfaces should be as specific and focused as possible, ensuring that classes only implement the methods they truly need.
   */

/**
 * 2. Example Scenario:
Consider an online buying system for cosmetic products with three payment categories: Installment, Cash, and Online Payments. 
Initially, there's a single large interface IOrder handling all payment categories.
 */

/**
 * 3. Problem Identification:
The IOrder interface contains methods for all payment categories, forcing classes to implement methods they don't need. 
This leads to strong coupling between classes and the interface, violating ISP.
 */

/** 4. Initial Implementation: */

interface IOrder {
    public function processInstallmentPayment();
    public function processCashPayment();
    public function processOnlinePayment();
}

class InstallmentPayment implements IOrder {
    public function processInstallmentPayment() {
        // Implementation
    }

    public function processCashPayment() {
        // Unused method, violates ISP
    }

    public function processOnlinePayment() {
        // Unused method, violates ISP
    }
}

// Similar implementations for CashPayment and OnlinePayment

class CashPayment implements ICashOrder {
    public function processInstallmentPayment() {
        // Unused method, violates ISP
    }
    public function processCashPayment() {
        // Implementation for processing cash payment
    }

    public function processOnlinePayment() {
        // Unused method, violates ISP
    }
}

class OnlinePayment implements IOnlineOrder {
    public function processInstallmentPayment() {
        // Unused method, violates ISP
    }
    public function processCashPayment() {
        // Unused method, violates ISP
    }
    public function processOnlinePayment() {
        // Implementation for processing online payment
    }
}

/**
 * 5. Solution - Implementing ISP:
To adhere to ISP, we need to split the large interface IOrder into smaller, more specific interfaces. 
Each class will then implement only the interfaces with methods it truly needs.
 */

/** 6. Refactored Implementation: */

interface IInstallmentOrder {
    public function processInstallmentPayment();
}

interface ICashOrder {
    public function processCashPayment();
}

interface IOnlineOrder {
    public function processOnlinePayment();
}

class InstallmentPayment implements IInstallmentOrder {
    public function processInstallmentPayment() {
        // Implementation
    }
}

class CashPayment implements ICashOrder {
    public function processCashPayment() {
        // Implementation
    }
}

class OnlinePayment implements IOnlineOrder {
    public function processOnlinePayment() {
        // Implementation
    }
}

/**
 * 7. Conclusion:
By implementing ISP, we reduce the large interface into smaller, more focused interfaces, ensuring that classes only implement methods they need. 
This reduces coupling, improves maintainability, and adheres to the SOLID principles of object-oriented design.
 */

 /** Link : https://h-benkachoud.medium.com/interface-segregation-principle-ec256f3828fe */