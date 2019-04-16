#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb 23 11:44:34 2019

"""

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import pyplot

dataset=pd.read_csv('heart.csv')
x=dataset.iloc[:,:-1].values
y=dataset.iloc[:,13].values

################################################################################
import statsmodels.formula.api as sm
x1=np.append(arr=np.ones((len(x),1)).astype(int),values=x,axis=1)
xopt=x1[:,:]


def backwardElimination(x, sl):
    numVars = len(x[0])
    for i in range(0, numVars):
        regressor_OLS = sm.OLS(y, x).fit()
        maxVar = max(regressor_OLS.pvalues).astype(float)
        if maxVar > sl:
            for j in range(0, numVars - i):
                if (regressor_OLS.pvalues[j].astype(float) == maxVar):
                    x = np.delete(x, j, 1)
    regressor_OLS.summary()
    return x
 
SL = 0.07
X_Modeled = backwardElimination(x, SL)



x1=X_Modeled


#cross validation
from sklearn.model_selection import train_test_split
xtrain,xtest,ytrain,ytest=train_test_split(X_Modeled,y,test_size=0.3,random_state=1)

from sklearn.svm import SVC
classifier=SVC(random_state=0)
classifier.fit(xtrain,ytrain)
ypred=classifier.predict(xtest)

from sklearn.metrics import confusion_matrix
cf=confusion_matrix(ytest,ypred)
print(cf)
accuracy=(cf[0][0]+cf[1][1])*100/len(xtest)
print(accuracy)





