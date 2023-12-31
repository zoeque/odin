# What's Odin  
This is a wordbook application that lists words like a list. This application supports learning by displaying registered words like a list.
This application supports only Japanese.

# Environment
- Java 17
- Android SDK 34 (min 24)

The ORM employs Room, and registered words are stored locally.  
In terms of architecture, the Activity class executes processes such as listening for buttons.  
The Adapter class performs as the list details to be displayed in the Activity class.  
Values are mapped in the Activity class, and row-by-row processing is handled by the Adapter class.

## Overview  
リストアップするような形で複数の単語を並べる単語帳アプリケーションです。  
不具合などありましたらissue起票にてご連絡ください。  

