import matplotlib.pyplot as plt
import numpy as np 
from sklearn.cluster import KMeans

X = np.array([[0.1,0.6],[0.15,0.71],[0.08,0.9],[0.16,0.85],[0.2,0.3],[0.25,0.5],[0.24,0.1],[0.3,0.2]])

initial_centroid = np.array([[0.1,0.6],[0.3,0.2]])

kmeans= KMeans(n_clusters=2, init=initial_centroid).fit(X)

print(kmeans.labels_) #classify and op  0/1 labellimg


print("P6 belongs to : ",kmeans.predict([[0.25,0.5]]))

db1_labels = kmeans.labels_
labels, counts = np.unique(db1_labels[db1_labels>=0], return_counts=True)
print("Population of m2 : ",counts[1])

print("m1 = ",kmeans.cluster_centers_[0])
print("m2 = ",kmeans.cluster_centers_[1]) 

plt.scatter(X[:,0],X[:,1], c=kmeans.labels_, cmap='rainbow') 
plt.show()

'''
output:

[0 0 0 0 1 0 1 1]
P6 belongs to :  [0]
Population of m2 :  3
m1 =  [0.148 0.712]
m2 =  [0.24666667 0.2       ]
'''
