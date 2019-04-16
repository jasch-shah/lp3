#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Apr 11 22:41:42 2019

@author: saurabh shelar
"""
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

dataset=pd.read_csv('Salary_Data.csv')
x=dataset.iloc[:,:-1].values
y=dataset.iloc[:,1].values

#split datset into train an test
from sklearn.model_selection import train_test_split
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=1/3,random_state=0)

#train the and fir the model
from sklearn.linear_model import LinearRegression
regressor=LinearRegression()
regressor.fit(x_train,y_train)

#predicting the test result set
y_pred=regressor.predict(x_test)

#for user enterd exp
exp=eval(input('Enter number of yrs of exp'))
sal=regressor.intercept_+(regressor.coef_*exp)   #y=b0+b1*x
print("Salary of rispective person will be: ",sal[0])

#to find accuracy of model
from sklearn.metrics import mean_squared_error
print("Accuracy pf simple L.R model is: ",mean_squared_error(y_test,y_pred))

#visualizing the training set results
plt.scatter(x_train,y_train,color='red')
plt.plot(x_train,regressor.predict(x_train),c='pink')
plt.title('Salary vs Experience (Training set)')
plt.xlabel('Years of experience')
plt.ylabel('Salary')
plt.show()

#visualizing the testing set results
plt.scatter(x_test,y_test,color='red')
plt.plot(x_train,regressor.predict(x_train),c='blue')
plt.title('Salary vs Experience (Testing set)')
plt.xlabel('Years of experience')
plt.ylabel('Salary')
plt.show()
