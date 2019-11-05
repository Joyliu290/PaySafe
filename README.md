# QHacks2019
# Background
We started this hackathon project at QHacks 2019 because we were all interested in implementing existing biometrics authentication and improve the security of authentication proce in the mobile banking industry. On-top of possible security concerns, my team and I are users of multiple banking accounts and often had to deal with the inefficient switch-of-apps and had to login again. Our own struggles sparked the idea of building a centralized banking app with secure authentication through the combination of voice, facial, and fingerprint authentication. Our plan for now is that once the user successfully passes the secure authentication through biometrics, then the user can freely access any of its bank accounts. For now, we're focusing on getting the authentication-side to work with basic banking functionality such as viewing account balance, and simple transfer and receive.

# Tech Stack
- We discovered that Plaid (https://plaid.com/docs/#auth) provides Instant Auth across multiple banks and we will be using that to provide the banking functionality of a centralized banking app

- We will be using Microsoft's facial detection and verificaiton API. The idea is that when the user first login, we will ask to take a picture of their face, and then send it to Microsoft, where they will then return back a unique string that indicate the faceID of the user�s face.

- We will also use Microsoft's speaker recognition API by first creating an identification profile for the user which will return a GUID that identifies the user. Then since the user is new, we will enrol the user into the MS speaker recognition database by letting the user read the sentence 3 times. Next time when user login, user will read the same sentence as a byte array and we will send that sentence over as a POST request to the MS endpoint and we will get back a confidence score of the match between the stored and given sample of voice. (https://www.henkboelman.com/articles/speaker-recognition/)

- For fingerprint, Android offers Fingerprint Dialogue for newer devices, where user first registers the fingerprint with the device (probably when user first gets the device), and then when user opens our app, it asks for fingerprint, and then matches the given fingerprint to the one stored in the Android system. There are more details of security on the Android side where it deals with symmetric keys and cipher, but the main idea is that our app will be matching the given fingerprint to the one stored in the phone to prove that it is indeed the correct user. (https://github.com/android/security-samples/tree/master/FingerprintDialogKotlin)

- To map these user information together, we are using Firebase NoSql database that uses a unique UserID to map key personal data together. Since we�re storing private personal data including voice and face IDs, we are currently reaching out to engineers working at companies that have products related to biometrics to learn about ways of encryption and how to safely store encryption keys.