# AQuery
A Write Less Do More Library for Android

AQuery is a lightweight library that allows UI manipulation in a syntactically similar way to the Javascript library JQuery. AQuery aims to remove the boilerplate code that comes with UI manipulation in Android. This helps with readability, ease of development and maintainability.

## Code Samples

Using AQuery Objects

```java
  
  // constructing an AQuery object from a context
  $ rootView = $(this); // the underlying View is the activity's root layout
  
  // constructing an AQuery object from a view
  $ someView = $(findViewById(R.id.some_view));
  
  // constructing an AQuery object from Resource Id
  $ anotherView = $(this, R.id.another_view));

  // to retrieve the plain View object:
  View rawView = someView.raw();
  
```


Login User Example

```java

  // vanilla Android
  
  Button loginButton = (Button) findViewById(R.id.login_button);
  button.setOnClickListener(view -> {
      EditText emailField = (EditText) findViewById(R.id.email);       
      EditText passwordField = (EditText) findViewById(R.id.password);
      
      String email = emailField.text().toString();
      String password = passwordField.text().toString();
      
      loginUser(email, password):
  });
  
```

```java

  // AQuery
  
  $(this, R.id.login_button).click(view -> {
      String email = $(this, R.id.email).text();
      String password = $(this, R.id.password).text();
      loginUser(email, password);
  });
  
```


Inflating Views

```java
  
  // Vanilla Android
  
  ViewGroup parent = (ViewGroup) findViewById(R.id.parent_layout);
  LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  View inflatedView = inflater.inflate(R.layout.child_view, parent);
  
  inflatedView.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
      inflatedView.getViewTreeObserver().removeOnGlobalLayoutListener(this); 
      Toast.makeText(this, "The view is rendered!!", Toast.LENGTH_SHORT).show();
  });
  
  inflatedView.setOnClickListener(view -> {
      // do something
  });
  
```

```java

  // AQuery
  
  $ parent = $(this, R.id.parent_layout);
  $.inflate(this, R.id.child_view, parent)
      .ready(() -> $.toast(this, "The view is rendered!!"))
      .click(view -> {
          // do something
      });
          
```


Animations

```java

  // vanilla Android
  
  View view = findViewById(R.id.animated_view);
  Animation animation = AnimationUtils.loadAnimation(this, R.anim.some_animation);
  animation.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {
      }

      @Override
      public void onAnimationEnd(Animation animation) {
          // do something
      }

      @Override
      public void onAnimationRepeat(Animation animation) {
      }
  });
  view.startAnimation(animation);
  
```

```java
  
  // AQuery
  
  $(this, R.id.animated_view)
       .animate(new AnimationBuilder(R.anim.some_animation, this)
       .onEnd(animation -> // do something)
       .build());
       
```

AQuery has a lot features other than the ones showcased here. You can view the [JavaDoc](https://mzaart.github.io/AQuery/) for detailed documentation.

## Getting Started

### Gradle

```
  repositories {
      maven {
          url  "https://dl.bintray.com/mzaart/Android" 
      }
  }

  dependencies {
      compile 'com.mzaart:aquery:1.0'
  }

```

You can import it as follows:

```java

  import com.mzaart.aquery.$;
  import static com.mzaart.aquery.Constructors.*;
  
```

Note that the static import isn't necessary. Its sole purpose is to make the instantiation of AQuery objects look as close as possible to JQeury.

```java
  
  // you can still use AQuery without the static import
  $ view = new $(this, R.id.some_view);

```

In fact, the static import is completely unnecessary in Kotlin since you create objects without the 'new' keyword.

```kotlin
  
  import com.mzaart.aquery.$;
  
  var view = $(this, R.id.some_view);
  
```

## License

```
Copyright (C) 2017 Mouhammed El Zaart

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

