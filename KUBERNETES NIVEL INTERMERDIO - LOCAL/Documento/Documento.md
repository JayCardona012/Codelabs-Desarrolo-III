# Kubernetes - Despliegue y Configuración de Aplicaciones

Este documento describe los pasos esenciales para desplegar aplicaciones en Kubernetes usando `Deployment`, `Service`, `ConfigMap`, `Secrets` y volúmenes.

---

## 1. Crear un Deployment y un Service en YAML

Creamos un archivo `webapp.yaml` que define un `Deployment` con 2 réplicas usando Nginx y un `Service` que expone la app vía `NodePort`.

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: webapp
spec:
  replicas: 2
  selector:
    matchLabels:
      app: webapp
  template:
    metadata:
      labels:
        app: webapp
    spec:
      containers:
      - name: nginx
        image: nginx
        ports:
        - containerPort: 80
---
apiVersion: v1
kind: Service
metadata:
  name: webapp-service
spec:
  selector:
    app: webapp
  type: NodePort
  ports:
    - port: 80
      targetPort: 80
      nodePort: 30080
```

**Descripción:**
- **Deployment:** Crea 2 pods ejecutando Nginx.
- **Service:** Permite acceder a la app en `http://localhost:30080`.

```bash
kubectl apply -f webapp.yaml
kubectl get deployments
kubectl get pods
kubectl get services
```

---

## 2. Externalizar configuración con ConfigMap

### Paso 1: Crear el ConfigMap

Archivo `configmap.yaml`:

```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: webapp-config
data:
  SALUDO: "¡Hola desde Kubernetes!"
```

```bash
kubectl apply -f configmap.yaml
```

### Paso 2: Usar el ConfigMap en el contenedor

Edita `webapp.yaml`, dentro de `containers:` agrega:

```yaml
env:
  - name: SALUDO
    valueFrom:
      configMapKeyRef:
        name: webapp-config
        key: SALUDO
```

Reaplica:

```bash
kubectl apply -f webapp.yaml
kubectl exec -it <nombre-del-pod> -- printenv SALUDO
```

---

## 3. Manejar información sensible con Secrets

### Paso 1: Crear el Secret

Archivo `secret.yaml`:

```yaml
apiVersion: v1
kind: Secret
metadata:
  name: webapp-secret
type: Opaque
data:
  PASSWORD: c2VjdXJvMTIz  # base64 de "seguro123"
```

```bash
kubectl apply -f secret.yaml
```

### Paso 2: Usar el Secret en el contenedor

Agrega al bloque `env:` del contenedor:

```yaml
- name: PASSWORD
  valueFrom:
    secretKeyRef:
      name: webapp-secret
      key: PASSWORD
```

Reaplica y verifica:

```bash
kubectl apply -f webapp.yaml
kubectl exec -it <nombre-del-pod> -- printenv PASSWORD
```

---

## 4. Montar archivos como volúmenes (ConfigMap → archivo)

### Paso 1: Crear el ConfigMap

Archivo `config-volume.yaml`:

```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: html-config
data:
  index.html: |
    <html>
      <body>
        <h1>¡Hola desde un volumen en Kubernetes!</h1>
      </body>
    </html>
```

```bash
kubectl apply -f config-volume.yaml
```

### Paso 2: Crear el deployment con volumen

Archivo `webapp-volumen.yaml`:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: webapp-volumen
spec:
  replicas: 1
  selector:
    matchLabels:
      app: webapp-volumen
  template:
    metadata:
      labels:
        app: webapp-volumen
    spec:
      containers:
      - name: nginx
        image: nginx
        volumeMounts:
        - name: html-volume
          mountPath: /usr/share/nginx/html
      volumes:
      - name: html-volume
        configMap:
          name: html-config
```

```bash
kubectl apply -f webapp-volumen.yaml
kubectl expose deployment webapp-volumen --type=NodePort --port=80 --name=webapp-volumen-service
kubectl get svc webapp-volumen-service
```
# Pasos de en el bash

![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-18%20222811.png)


![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-18%20222819.png)

---

## Resultado de la Implementación

```bash
kubectl get pods
# webapp-579fc98f5-42wzj   1/1     Running

kubectl exec -it webapp-579fc98f5-42wzj -- printenv SALUDO
# ¡Hola desde Kubernetes!

kubectl apply -f secret.yaml
# secret/webapp-secret configured

kubectl exec -it webapp-579fc98f5-42wzj -- printenv PASSWORD
# tu-contraseña-segura

kubectl apply -f config-volume.yaml
kubectl apply -f webapp-volumen.yaml
kubectl expose deployment webapp-volumen --type=NodePort --port=80 --name=webapp-volumen-service
kubectl get svc webapp-volumen-service
# PORT(S): 80:31037/TCP

```
![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-18%20222747.png)

---
