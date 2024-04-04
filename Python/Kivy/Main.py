from kivy.app import App
from kivy.lang import Builder

GUI = Builder.load_file("Tela.kv")

class MeuAplicativo(App):
    def build(self):
        return GUI
    
MeuAplicativo().run()