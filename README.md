# Java Persian Calendar

The main class of this project that you can copy to your project
freely is [PersianCalendar](https://github.com/hadilq/java-persian-calendar/blob/master/persian/src/main/java/ir/hadilq/PersianCalendar.java).
There is some functiions in [CalendarsUtil](https://github.com/hadilq/java-persian-calendar/blob/master/persian/src/main/java/ir/hadilq/util/CalendarsUtil.java),
which you can copy to the calendar class for your project.

This calendar is unlimited as long as Kayyam rules and Java are correct.
You can see important functions in [here](https://github.com/hadilq/persian-calendar-important-functions) and [here](https://en.wikibooks.org/wiki/Persian_Calendar).
And if you want to more proof of correctness of this class you can see the tests.
 
However, this class is written in android project structure, you can simply use it in java projects.

BTW, roll method of calendar is not supported, and I have no plan to support it.
Also, The maximum and minimum of fields are not carefully determined yet, but as you can see in tests,
from year 3000 before hijra to 3000 after hijra is a valid interval for this calendar.


## Usage

You can use it like this

```Java
PersianCalendar calendar = new PersianCalendar();
calendar.setTimeInMillis(time);
int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH); // zero base just like standard Java SDK calendar
int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
int minute = calendar.get(Calendar.MINUTE);
int second = calendar.get(Calendar.SECOND);
```

Or you can use it like this

```Java
PersianCalendar calendar = new PersianCalendar(1395, 7, 23, 10, 56, 52);
long millis = calendar.getTimeInMillis()
```

Also you can use add method like this

```Java
calendar.add(Calendar.DATE, 1);
```

Or this

```Java
calendar.add(Calendar.DATE, -1);
```
