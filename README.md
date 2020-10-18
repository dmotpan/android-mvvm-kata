### MVVM Android Kata

## Goal

The goal of this Kata is to get familiar with MVVM architecture pattern

## MVVM architecture pattern
MVVM architecture pattern is a Model-View-ViewModel architecture that removes the tight coupling between each component.
Most importantly, in this architecture, the children don't have the direct reference to the parent, they only have the reference by observables.

![MVVM](https://s3.ap-south-1.amazonaws.com/mindorks-server-uploads/mvvm.png) [1]
- Model: It represents the data and the business logic of the Android Application. It consists of the business logic - local and remote data source, model classes, repository.
- View: It consists of the UI Code(Activity, Fragment), XML. It sends the user action to the ViewModel but does not get the response back directly. To get the response, it has to subscribe to the observables which ViewModel exposes to it.
- ViewModel: It is a bridge between the View and Model(business logic). It does not have any clue which View has to use it as it does not have a direct reference to the View. So basically, the ViewModel should not be aware of the view who is interacting with. It interacts with the Model and exposes the observable that can be observed by the View.

## Application use-cases

* I want to be able to see the temperature in London
* I want to see the error screen if the request failed
* I want to see the Konfetti animation when I click on on the temperature
* I want the application to handle screen rotations gracefully

## Resources
1. Scheme + MVVM https://blog.mindorks.com/mvc-mvp-mvvm-architecture-in-android
2. MVVM https://blog.mindorks.com/mvvm-architecture-android-tutorial-for-beginners-step-by-step-guide
3. viewModelScope https://medium.com/androiddevelopers/easy-coroutines-in-android-viewmodelscope-25bffb605471
4. Flow: https://proandroiddev.com/using-livedata-flow-in-mvvm-part-ii-252ec15cc93a

## License

Copyright 2020

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
