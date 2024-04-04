# importar o App, Builder (GUI)
# # criar o nosso aplicativo
# # criar a função build

from kivy.app import App
from kivy.lang import Builder
import requests

class MeuAplicativo(App):
    def build(self):
        return GUI

MeuAplicativo().run()