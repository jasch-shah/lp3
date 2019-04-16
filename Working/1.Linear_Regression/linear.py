import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

dataset = pd.read_csv("/home/msv/data.csv")
X=dataset[['Hours']]
y=dataset[['Risk']]

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.4)
lm = LinearRegression()
lm.fit(X,y)
#lm.fit(X_train,y_train)
b0=lm.intercept_
b1=lm.coef_

print("Equation y= ",b0,"+",b1,"x")
x_input=input("Enter value of x to predict value of y")
x_input=int(x_input)
y_pred=(b0)+(b1*x_input)

print("Predicted value of y is ",y_pred)
predictions = lm.predict(X)
#predictions = lm.predict(X_test)
print(predictions)
#plt.scatter(X_train,y_train)
#plt.scatter(X_test,predictions)
plt.plot(X,y,'o')
plt.plot(X, predictions,'r')
#plt.scatter(X_test,predictions)
#plt.plot(X_test, predictions, color='blue', linewidth=3)
#plt.xticks(())
#plt.yticks(())
plt.show()



"""
python3 test.py
Equation y=  [10.77721519] + [[6.4835443]] x
Enter value of x to predict value of y3
Predicted value of y is  [[30.2278481]]
"""
